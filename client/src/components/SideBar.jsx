import React from 'react';

import {
  BsCart3,
  BsGrid1X2Fill,
  BsFillArchiveFill,
  BsFillGrid3X3GapFill,
  BsPeopleFill,
  BsListCheck,
  BsMenuButtonWideFill,
  BsFillGearFill,
} from 'react-icons/bs';
const SideBar = ({ openSidebarToggle, OpenSidebar }) => {
  return (
    <aside
      id="sidebar"
      className={openSidebarToggle ? 'sidebar-responsive' : 'closed'}
    >
      <div className="sidebar-title">
        <div className="sidebar-brand">Dashboard</div>
        <span className="icon close_icon" onClick={OpenSidebar}>
          X
        </span>
      </div>

      <ul className="sidebar-list">
        <li className="sidebar-list-item">
          <a href="">
            <BsGrid1X2Fill className="icon" /> Home
          </a>
        </li>
        <li className="sidebar-list-item">
          <a href="">
            <BsFillArchiveFill className="icon" /> Paper Info
          </a>
        </li>

        <li className="sidebar-list-item logout">
          <a href="/">
            <BsFillGearFill className="icon" /> Logout
          </a>
        </li>
      </ul>
    </aside>
  );
};

export default SideBar;
