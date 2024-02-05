import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../assets/styles/Landing.css';
import waltuh from '../assets/image/speaker1.png';
import kevin from '../assets/image/second.jpeg';
import Login from '../components/Login';

const LandingPage = () => {
  const navigate = useNavigate();
  const SubmitDetails = () => {
    navigate('/login');
  };

  return (
    <div>
      <div className="landing-container">
        <div className="landing-top">
          <div className="landing-header">
            <Login />
          </div>
          <div className="landing-main">
            <h2 className="landing-title">
              NITCONF <span style={{ color: 'white' }}>2024</span>
            </h2>
          </div>
        </div>
        <div className="landing-about">
          <div className="about-content">
            <h1
              style={{
                fontSize: '3rem',
                textDecoration: 'underline',
                textUnderlinePosition: 'under',
                textDecorationThickness: '0.6rem',
                textDecorationColor: 'red',
              }}
            >
              About NITCONF
            </h1>
            <p className="about-text">
              NITCONF is a new way of setting up your conference paper
              informations.It completely transforms the way you manage your
              papers.
            </p>
          </div>
        </div>
        <div className="landing-speakers">
          <h1 className="speakersectiontitle">Keynote Speakers</h1>
          <div className="firstspeaker">
            <img style={{ borderRadius: '20px' }} src={waltuh} alt="" />
            <div className="firstspeakercontent">
              <h2 style={{ padding: '2rem', fontSize: '3rem' }}>Heisenberg</h2>
              <p style={{ padding: '2rem', width: '40vw' }}>
                Professor Heisenberg,a well established chemist and a well known
                teacher famous for his cooking skills.
              </p>
            </div>
          </div>
          <div className="secondspeaker">
            <div className="secondspeakercontent">
              <h2 style={{ padding: '2rem', fontSize: '3rem' }}>
                Kevin Parker
              </h2>
              <p style={{ padding: '2rem', width: '40vw', fontSize: '1rem' }}>
                Kevin Parker's keynote unfolds like a sonic journey, blending
                introspective anecdotes with the evolution of Tame Impala's
                sound. He delves into the symbiosis of creativity and
                technology, leaving the audience inspired.
              </p>
            </div>
            <img style={{ borderRadius: '20px' }} src={kevin} alt="" />
          </div>
        </div>
      </div>
    </div>
  );
};

export default LandingPage;
