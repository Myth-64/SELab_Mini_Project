import React, { useContext } from 'react';
import { AuthContext } from '../auth/AuthContext';
import { useNavigate } from 'react-router-dom';
const Logout = () => {
  const { user, setUser } = useContext(AuthContext);
  setUser('');
  localStorage.removeItem('token');
  const navigate = useNavigate();
  navigate('/');
};

export default Logout;
