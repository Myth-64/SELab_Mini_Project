import Dashboard from './pages/Dashboard';
import LandingPage from './pages/LandingPage';
import Login from './pages/Login';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import HomeLayout from './pages/HomeLayout';
import Home from './pages/Home';
import PaperInfo from './pages/PaperInfo';
import './App.css';
import { PaperDetail } from './pages/PaperDetail';
import PrivateRoutes from './auth/PrivateRoutes';
import { useState } from 'react';
import { AuthContext } from './auth/AuthContext';
import Logout from './pages/Logout';

import { loader as paperloader } from './pages/Home';
import { loader as paperinfoloader } from './pages/PaperInfo';
import { loader as paperdetailloader } from './pages/PaperDetail';
import AssignReviewers from './pages/AssignReviewers';
const router = createBrowserRouter([
  {
    path: '/',
    element: <HomeLayout />,
    children: [
      {
        index: true,
        element: <LandingPage />,
      },
      {
        path: 'login',
        element: <Login />,
      },

      {
        element: <PrivateRoutes />,
        children: [
          {
            path: 'dashboard',
            element: <Dashboard />,
            children: [
              {
                index: true,
                loader: paperloader,
                element: <Home />,
              },

              {
                path: 'paperinfo',
                loader: paperinfoloader,
                element: <PaperInfo />,
              },
              {
                path: 'paperdetail/:paperId',
                loader: paperdetailloader,
                element: <PaperDetail />,
              },
              {
                path: 'logout',
                element: <Logout />,
              },
            ],
          },
        ],
      },
    ],
  },
]);

// function App() {
//   return (
//     <BrowserRouter>
//       <Routes>
//         <Route path="/">
//           <Route index element={<LandingPage />} />
//           <Route path="login" element={<Login />} />
//           <Route path="dashboard" element={<Dashboard />} />
//         </Route>
//       </Routes>
//     </BrowserRouter>
//   );
// }
export const App = () => {
  const [user, setUser] = useState('');
  return (
    <AuthContext.Provider value={{ user, setUser }}>
      <RouterProvider router={router}></RouterProvider>
    </AuthContext.Provider>
  );
};

export default App;
