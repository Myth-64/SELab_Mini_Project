import React from 'react';
import '../assets/styles/SideBar.css';
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
import { NavLink } from 'react-router-dom';
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
          <div>
            <NavLink
              to={'.'}
              key={'Home'}
              className="nav-link"
              end
              style={{ color: 'inherit', textDecoration: 'inherit' }}
            >
              <BsGrid1X2Fill className="icon" /> {'Home'}
            </NavLink>
          </div>
        </li>
        <li className="sidebar-list-item">
          <div>
            <NavLink
              to={'paperinfo'}
              key={'paperinfo'}
              className="nav-link"
              end
              style={{ color: 'inherit', textDecoration: 'inherit' }}
            >
              <span>
                <BsFillArchiveFill className="icon" />
              </span>
              Paper Info
            </NavLink>
          </div>
        </li>

        <li className="sidebar-list-item logout">
          <div>
            <NavLink
              to={'logout'}
              key={'logout'}
              className="nav-link"
              end
              style={{ color: 'inherit', textDecoration: 'inherit' }}
            >
              <BsFillGearFill className="icon" /> Logout
            </NavLink>
          </div>
        </li>
      </ul>
    </aside>
  );
};

export default SideBar;
