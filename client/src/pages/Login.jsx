import React, { useContext, useState } from 'react';
import '../assets/styles/Login.css';
import axios from 'axios';
import { redirect, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import { AuthContext } from '../auth/AuthContext';

const Login = () => {
  const { user, setUser } = useContext(AuthContext);
  const navigate = useNavigate();
  const handleSubmit = async (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const credentials = Object.fromEntries(formData);
    try {
      const resp = await axios.post(
        'http://localhost:8080/api/authenticate',
        credentials
      );
      toast.success('login success');
      localStorage.setItem('token', resp.data);
      setUser(credentials.username);
      console.log('yes');
      navigate('/dashboard');
    } catch (error) {
      toast.error('Invalid Credentials');
    }
  };

  return (
    <div className="MainElement">
      <div className="wrapper">
        <header>Login Form</header>
        <form onSubmit={handleSubmit} id="loginform">
          <div className="field email">
            <div className="input-area">
              <input type="text" placeholder="username" name="username" />
              <i className="icon fas fa-envelope"></i>
              <i className="error error-icon fas fa-exclamation-circle"></i>
            </div>
            <div className="error error-txt">Email can't be blank</div>
          </div>
          <div className="field password">
            <div className="input-area">
              <input type="password" placeholder="password" name="password" />
              <i className="icon fas fa-lock"></i>
              <i className="error error-icon fas fa-exclamation-circle"></i>
            </div>
            <div className="error error-txt">Password can't be blank</div>
          </div>
          <div className="pass-txt">
            <a href="#">Forgot password?</a>
          </div>
          <input type="submit" value="Login" />
        </form>
        <div className="sign-txt">
          Not yet member? <a href="#">Signup now</a>
        </div>
      </div>
    </div>
  );
};

export default Login;
