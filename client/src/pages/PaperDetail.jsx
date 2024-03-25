import React from 'react';
import '../assets/styles/PaperDetails.css';
import { useState } from 'react';
import AssignModal from '../components/AssignModal';
import { useLoaderData, useLocation } from 'react-router-dom';
import CheckModal from '../components/CheckModal';
import { toast } from 'react-toastify';
import axios from 'axios';

var paperId_param;
var reviewlist;
export const loader = async ({ params }) => {
  paperId_param = params.paperId;
  try {
    const resp = await fetch(
      `http://localhost:8080/api/papers/findById?id=${params.paperId}`,
      { method: 'GET' }
    );
    const paperdata = await resp.json();
    const review = await fetch(
      `http://localhost:8080/api/reviews/findByPaperCompleted?paperId=${params.paperId}`,
      { method: 'GET' }
    );
    const reviewdata = await review.json();
    return { paperdata, reviewdata };
  } catch (error) {
    return error;
  }
};

export const PaperDetail = () => {
  const { paperdata, reviewdata } = useLoaderData();
  const paperId = paperId_param;
  const location = useLocation();
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [isCheckModalOpen, setIsCheckModalOpen] = useState(false);
  const [modalContent, setModalContent] = useState('');
  const [checkModalContent, setCheckModalContent] = useState('');
  const [isreviewModalOpen, setIsReviewModalOpen] = useState(false);
  const [reviewmodalContent, setreviewModalContent] = useState('');
  const reviewedarray = new Array();

  const openModal = async () => {
    //make openmodal async and fetch information from here
    const contentresp = await fetch(
      `http://localhost:8080/api/papers/getReviewers?paperId=${paperId_param}`,
      { method: 'GET' }
    );
    reviewedarray.length = 0;
    const content = await contentresp.json();
    // {
    //   console.log('hi');
    //   content.map((e) => {
    //     const { id } = e;
    //     reviewedarray.push(id);
    //   });
    //   console.log(reviewedarray);
    // }

    setIsModalOpen(true);
    setModalContent(content);
  };

  const openCheckModal = async (paperId) => {
    const contentresp = await fetch(
      `http://localhost:8080/api/reviews/findByPaper?paperId=${paperId_param}`,
      { method: 'GET' }
    );
    const content = await contentresp.json();

    setIsCheckModalOpen(true);
    setCheckModalContent(content);
  };
  const closeModal = () => {
    setIsModalOpen(false);
  };
  const closeCheckModal = () => {
    setIsCheckModalOpen(false);
  };

  const handleaccept = async () => {
    //check for under review status
    //paperId_param
    const data = { paperId: paperId_param };

    try {
      const resp = await axios.post('http://localhost:8080/api/papers/accept', {
        paperId: paperId_param,
      });

      toast.success('Paper accepted');
    } catch (error) {
      toast.error('Paper cannot be accepted');
    }
  };

  const handlereject = async () => {
    //check for under review status
    //paperId_param
    const data = { paperId: paperId };
    try {
      const resp = await axios.post(
        'http://localhost:8080/api/papers/reject',
        data
      );
    } catch (error) {
      toast.error('Paper cannot be rejected');
    }
  };

  const handlenotifications = async () => {
    const data = { paperId: paperId };
    try {
      const resp = await axios.post(
        'http://localhost:8080/api/papers/notify',
        data
      );
      toast.success('Sent notifications successfully');
    } catch (error) {
      toast.error('Cant send notification');
    }
  };

  return (
    <>
      <div className="titlebox">
        <div className="paperbox">
          <h2>{paperdata.title}</h2>
          <h4>by: {paperdata.author.name}</h4>
          <h5> {paperdata.description} </h5>
          <div className="tagbox">
            tags:
            {paperdata.tracks.map((trackelement) => {
              return (
                <div className="tag" key={trackelement.trackId}>
                  {trackelement.title}
                </div>
              );
            })}
          </div>
        </div>
      </div>
      <div className="panel">
        <button onClick={() => openModal()}>Assign reviewers</button>
        <button
          //make this button fetch reviewer info
          onClick={() => openCheckModal(paperId)}
        >
          Check reviewers
        </button>
        <button onClick={handleaccept}>Accept</button>
        <button onClick={handlereject}>Reject</button>
        <button onClick={handlenotifications}>Remind Reviewers</button>
        <section>
          <AssignModal
            isModalOpen={isModalOpen}
            modalContent={modalContent}
            onClose={closeModal}
            setModalContent={setModalContent}
            paperId={paperId}
          />
        </section>
        <section>
          <CheckModal
            isModalOpen={isCheckModalOpen}
            modalContent={checkModalContent}
            onClose={closeCheckModal}
            setModalContent={setCheckModalContent}
          />
        </section>
      </div>
      <div className="review-outerbox">
        <div className="review-box">
          <h2>Reviews</h2>
          {reviewdata.map((details, index) => {
            const { reviewDescription, author } = details;

            return (
              <div className="paperdetailbox" key={index}>
                <h4
                  style={{ fontFamily: 'sans-serif', fontWeight: 'normal' }}
                  onClick={(e) => gotoDetail(e, review)}
                >
                  {reviewDescription} by - {author.name}
                </h4>
              </div>
            );
          })}
        </div>
      </div>
    </>
  );
};
