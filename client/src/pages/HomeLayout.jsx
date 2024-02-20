import React from 'react';
import { Outlet } from 'react-router-dom';

const HomeLayout = () => {
  return (
    <div>
      <Outlet></Outlet>
    </div>
  );
};

export default HomeLayout;
