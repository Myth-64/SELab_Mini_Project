import React, { useState } from 'react';
import Navbar from '../components/Navbar';
import SideBar from '../components/SideBar';
import Home from './Home';

const Dashboard = () => {
  const [openSidebarToggle, setOpenSidebarToggle] = useState(false);

  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle);
  };
  return (
    <div className="grid-container">
      <Navbar OpenSidebar={OpenSidebar} />
      <SideBar
        openSidebarToggle={openSidebarToggle}
        OpenSidebar={OpenSidebar}
      />
      <Home />
    </div>
  );
};

export default Dashboard;
