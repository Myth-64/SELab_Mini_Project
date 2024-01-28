import React from "react";
import { useNavigate } from "react-router-dom";

const LandingPage = () => {
  const navigate = useNavigate();
  const SubmitDetails = () => {
    navigate("/login");
  };

  return (
    <div>
      <button onClick={SubmitDetails}>LOGIN</button>
    </div>
  );
};

export default LandingPage;
