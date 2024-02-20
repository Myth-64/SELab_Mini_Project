import React, { useState } from 'react';
import Navbar from '../components/Navbar';
import SideBar from '../components/SideBar';
import Home from './Home';
import { Outlet } from 'react-router-dom';

const Dashboard = () => {
  const [openSidebarToggle, setOpenSidebarToggle] = useState(false);
  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle);
  };
  return (
    <div className="grid-container">
      <Navbar OpenSidebar={OpenSidebar} />
      <div>
        <SideBar
          openSidebarToggle={openSidebarToggle}
          OpenSidebar={OpenSidebar}
        />
      </div>
      <div className="outlet">
        <Outlet />
      </div>
    </div>
  );
};

export default Dashboard;
