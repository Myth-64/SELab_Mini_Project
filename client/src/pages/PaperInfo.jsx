import React from 'react';
import { useLoaderData, useNavigate, Link } from 'react-router-dom';
import '../assets/styles/Paperinfo.css';
import axios from 'axios';

export const loader = async () => {
  try {
    const resp = await axios.get('http://localhost:8080/api/papers');
    return resp.data;
  } catch (error) {
    return error;
  }
};
const paperdetails = [
  {
    papertitle: 'The insights of ruminal culturomics',
    paperstatus: 'Pending',
  },
  {
    papertitle: 'Political Environment in the Middle East',
    paperstatus: 'Reviewed',
  },
  {
    papertitle: 'EV vehicles and how they are useless',
    paperstatus: 'Submitted',
  },
  {
    papertitle: 'The concept of global health security',
    paperstatus: 'Submitted',
  },
  {
    papertitle: 'The healthy food standards are not always unbiased',
    paperstatus: 'Submitted',
  },
  {
    papertitle:
      'The Efficacy of Plant-based Diets in Preventing Chronic Diseases',
    paperstatus: 'Reviewed',
  },
  {
    papertitle: 'The psychological aspect in the perception of allergies',
    paperstatus: 'Reviewed',
  },
];

const statusMap = new Map([
  ['UNASSIGNED', 'Unassigned'],
  ['UNDER_REVIEW', 'Under Review'],
  ['COMPLETED_REVIEW', 'Completed Review'],
  ['ACCEPTED', 'Accepted'],
  ['REJECTED', 'Rejected'],
]);

const PaperInfo = () => {
  const response = useLoaderData();
  const navigate = useNavigate();

  const gotoDetail = async (event, paperId) => {
    event.preventDefault();
    navigate(`/dashboard/paperdetail/${paperId}`, {
      state: { paperId: { paperId } },
    });
    try {
      //get paper info from backend
    } catch (error) {
      //handle error maybe with toast
    }
  };

  return (
    <div className="paper-maincontainer">
      <h1>Paper Info</h1>
      <div className="paperinfo-header">
        <h3>Paper Title</h3>
        <h3>Status</h3>
      </div>
      {response.map((paper) => {
        const { paperId, title, status } = paper;
        var color;
        switch (status) {
          case 'UNASSIGNED':
            color = 'blue';
            break;
          case 'COMPLETED_REVIEW':
            color = 'orange';
            break;
          case 'UNDER_REVIEW':
            color = 'violet';
            break;
          case 'ACCEPTED':
            color = 'green';
            break;
          case 'REJECTED':
            color = 'red';
            break;
          default:
        }

        return (
          <div className="paperinfobox">
            <h4
              style={{ fontFamily: 'sans-serif', fontWeight: 'normal' }}
              onClick={(e) => gotoDetail(e, paperId)}
            >
              {title}
            </h4>
            <div className={'box'} style={{ backgroundColor: color }}>
              <div style={{ color: 'white' }}>{statusMap.get(status)}</div>
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default PaperInfo;
