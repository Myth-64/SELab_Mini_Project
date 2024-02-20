import React from 'react';
import { Navigate, Outlet, useLocation } from 'react-router-dom';

const PrivateRoutes = () => {
  const location = useLocation();
  const authLogin = localStorage.getItem('token');
  console.log(authLogin);
  return authLogin ? (
    <Outlet />
  ) : (
    <Navigate to="/login" replace state={{ from: location }} />
  );
};

export default PrivateRoutes;
