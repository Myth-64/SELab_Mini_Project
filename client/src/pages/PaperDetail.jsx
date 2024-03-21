import React from 'react';
import '../assets/styles/PaperDetails.css';
import { useState } from 'react';
import AssignModal from '../components/AssignModal';
import { useLoaderData, useLocation } from 'react-router-dom';

var paperId_param;
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
  console.log(reviewdata);
  const location = useLocation();
  const paperinformation = {
    papertitle: 'The insights of ruminal culturomics',
    paperstatus: 'Pending',
    author: 'Mike Wazowski',
    tags: ['historical', 'cultural', 'ethnic', 'ethnic', 'ethnic'],
  };

  const paperdetails = [
    {
      review:
        '    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
      reviewer: 'Pending',
    },
    {
      review:
        '    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
      reviewer: 'Pending',
    },
    {
      review:
        '    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
      reviewer: 'Pending',
    },
    {
      review:
        '    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
      reviewer: 'Pending',
    },
  ];

  const assignees = [
    {
      name: 'Michael',
      status: 'Not assigned',
    },
    {
      name: 'Pickford',
      status: 'Assigned',
    },
    {
      name: 'Bellingham',
      status: 'Assigned',
    },
  ];

  const { papertitle, paperstatus, author, tags } = paperinformation;
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [modalContent, setModalContent] = useState('');
  const [isreviewModalOpen, setIsReviewModalOpen] = useState(false);
  const [reviewmodalContent, setreviewModalContent] = useState('');

  const openModal = async () => {
    //make openmodal async and fetch information from here
    const contentresp = await fetch(
      `http://localhost:8080/api/papers/getReviewers?paperId=${paperId_param}`,
      { method: 'GET' }
    );
    const content = await contentresp.json();
    setIsModalOpen(true);
    setModalContent(content);
  };

  const fetchreviewers = async (paperId) => {
    //make openmodal async and fetch information from here
    setIsReviewModalOpen(true);
    setreviewModalContent(content);
  };
  const closeModal = () => {
    setIsModalOpen(false);
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
        <button onClick={() => openModal(assignees)}>Assign reviewers</button>
        <button
          //make this button fetch reviewer info
          onClick={() => fetchreviewers(paperId)}
        >
          Check reviewers
        </button>
        <button>Accept</button>
        <button>Reject</button>
        <section>
          <AssignModal
            isModalOpen={isModalOpen}
            modalContent={modalContent}
            onClose={closeModal}
            setModalContent={setModalContent}
          />
        </section>
        <section>
          <AssignModal
            isModalOpen={isModalOpen}
            modalContent={modalContent}
            onClose={closeModal}
            setModalContent={setModalContent}
          />
        </section>
      </div>

      <div className="review-outerbox">
        <div className="review-box">
          <h2>Reviews</h2>
          {reviewdata.map((details, index) => {
            const { reviewDescription, author } = details;
            console.log(reviewDescription);
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
