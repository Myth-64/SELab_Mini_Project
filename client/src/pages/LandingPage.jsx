import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../assets/styles/Landing.css';
import sam from '../assets/image/sam.jpeg';
import alex from '../assets/image/alex.jpeg';
import Login from '../components/Login';

const LandingPage = () => {
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
            <p
              className="about-text"
              style={{ fontSize: '2.5rem', width: '90vw' }}
            >
              NITCONF is a comprehensive conference web app designed to
              streamline the management of conference papers, reviewes and
              related details. Offering a user-friendly interface, it enables
              organizers to efficiently handle submissions and allocate
              reviewers. With robust features for collaboration and
              communication, NITCONF ensures smooth coordination and enhances
              the overall conference experience for organizers, reviewers, and
              participants.
            </p>
          </div>
        </div>
        <div className="landing-speakers">
          <h1 className="speakersectiontitle">Keynote Speakers</h1>
          <div className="firstspeaker">
            <img style={{ borderRadius: '20px' }} src={sam} alt="" />
            <div className="firstspeakercontent">
              <h2 style={{ padding: '2rem', fontSize: '3rem' }}>
                Samuel Reynolds
              </h2>
              <p style={{ padding: '2rem', width: '60vw', fontSize: '2.5rem' }}>
                Samuel Reynolds is renowned for his mastery in safeguarding the
                Internet of Things (IoT) through blockchain solutions, ensuring
                trust and integrity. With a blend of technical expertise and
                strategic foresight, Reynolds pioneers innovative approaches to
                fortify IoT ecosystems against cyber threats, setting new
                standards for security in digital landscapes.
              </p>
            </div>
          </div>
          <div className="secondspeaker">
            <div className="secondspeakercontent">
              <h2 style={{ padding: '2rem', fontSize: '3rem' }}>
                Alexander Hayes
              </h2>
              <p style={{ padding: '2rem', width: '58vw', fontSize: '2.5rem' }}>
                Alexander Hayes is celebrated for his expertise in deciphering
                the implications of quantum computing on cybersecurity,
                navigating challenges and seizing opportunities. With a deep
                understanding of both fields, Hayes leads the charge in
                developing strategies to fortify digital defenses and harness
                the potential of quantum technology in safeguarding sensitive
                information.
              </p>
            </div>
            <img style={{ borderRadius: '20px' }} src={alex} alt="" />
          </div>
        </div>
      </div>
    </div>
  );
};

export default LandingPage;
