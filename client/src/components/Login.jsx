import React from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const navigate = useNavigate();
  const Submitbutton = () => {
    navigate('/login');
  };
  return (
    <button className="login-box" onClick={Submitbutton}>
      Login
    </button>
  );
};

export default Login;
