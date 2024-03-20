import axios from 'axios';
import React from 'react';
import {
  BsFillArchiveFill,
  BsFillGrid3X3GapFill,
  BsPeopleFill,
  BsFillBellFill,
} from 'react-icons/bs';
import { useLoaderData } from 'react-router-dom';

var unassigned_count=0,
  pending_review_count=0,
  completed_review_count=0,
  accepted_count=0,
  rejected_count=0;
export const loader = async () => {
  try {
    const resp = await axios.get(
      'http://localhost:8080/api/papers/countByStatus'
    );
    return resp.data;
  } catch (error) {
    return error;
  }
};

function Home() {
  const response = useLoaderData();
  console.log(response);
  for(let i=0;i<response.length;i++){
    if(response[i].status=='UNASSIGNED'){
      unassigned_count=response[i].count;
    }
    else if(response[i].status=='UNDER_REVIEW'){
      pending_review_count=response[i].count;
    }
    else if(response[i].status=='COMPLETED_REVIEW'){
      completed_review_count=response[i].count;
    }
    else if(response[i].status=='ACCEPTED'){
      accepted_count=response[i].count;
    }
    else if(response[i].status=='REJECTED'){
      rejected_count=response[i].count;
    }
  }
  const data = [
    {
      name: 'Page A',
      uv: 4000,
      pv: 2400,
      amt: 2400,
    },
    {
      name: 'Page B',
      uv: 3000,
      pv: 1398,
      amt: 2210,
    },
    {
      name: 'Page C',
      uv: 2000,
      pv: 9800,
      amt: 2290,
    },
    {
      name: 'Page D',
      uv: 2780,
      pv: 3908,
      amt: 2000,
    },
    {
      name: 'Page E',
      uv: 1890,
      pv: 4800,
      amt: 2181,
    },
    {
      name: 'Page F',
      uv: 2390,
      pv: 3800,
      amt: 2500,
    },
    {
      name: 'Page G',
      uv: 3490,
      pv: 4300,
      amt: 2100,
    },
  ];

  return (
    <main className="main-container">
      <div className="main-cards">
        <div className="card">
          <div className="card-inner">
            <h3>Unassigned</h3>
            <BsFillArchiveFill className="card_icon" />
          </div>
          <h1>{unassigned_count}</h1>
        </div>
        <div className="card">
          <div className="card-inner">
            <h3>Under Review</h3>
            <BsFillGrid3X3GapFill className="card_icon" />
          </div>
          <h1>{pending_review_count}</h1>
        </div>
        <div className="card">
          <div className="card-inner">
            <h3>Completed Review</h3>
            <BsFillBellFill className="card_icon" />
          </div>
          <h1>{completed_review_count}</h1>
        </div>
        <div className="card">
          <div className="card-inner">
            <h3>Accepted</h3>
            <BsPeopleFill className="card_icon" />
          </div>
          <h1>{accepted_count}</h1>
        </div>
        <div className="card">
          <div className="card-inner">
            <h3>Rejected</h3>
            <BsFillBellFill className="card_icon" />
          </div>
          <h1>{rejected_count}</h1>
        </div>
      </div>
    </main>
  );
}

export default Home;
