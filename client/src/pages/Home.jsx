import axios from "axios";
import React from "react";
import {
  BsFillArchiveFill,
  BsFillGrid3X3GapFill,
  BsPeopleFill,
  BsFillBellFill,
} from "react-icons/bs";

var unassigned_count,
  pending_review_count,
  completed_review_count,
  accepted_count,
  rejected_count;
export const loader = async () => {
  try {
    const data = { status: "UNASSIGNED" };
    const resp = await axios.get(
      "http://localhost:8080/api/papers/countByStatus"
    );
    unassigned_count = resp.data;
    console.log(resp.data);
    const tempMap = resp.data.reduce(function (map, obj) {
      map[obj.status] = obj.count;
      return map;
    });
    console.log(tempMap);
    return resp.data;
  } catch (error) {
    return error;
  }
};

function Home() {
  const data = [
    {
      name: "Page A",
      uv: 4000,
      pv: 2400,
      amt: 2400,
    },
    {
      name: "Page B",
      uv: 3000,
      pv: 1398,
      amt: 2210,
    },
    {
      name: "Page C",
      uv: 2000,
      pv: 9800,
      amt: 2290,
    },
    {
      name: "Page D",
      uv: 2780,
      pv: 3908,
      amt: 2000,
    },
    {
      name: "Page E",
      uv: 1890,
      pv: 4800,
      amt: 2181,
    },
    {
      name: "Page F",
      uv: 2390,
      pv: 3800,
      amt: 2500,
    },
    {
      name: "Page G",
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
            <h3>Submitted</h3>
            <BsFillArchiveFill className="card_icon" />
          </div>
          <h1>3</h1>
        </div>
        <div className="card">
          <div className="card-inner">
            <h3>Pending</h3>
            <BsFillGrid3X3GapFill className="card_icon" />
          </div>
          <h1>1</h1>
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
          <h1>2</h1>
        </div>
      </div>
    </main>
  );
}

export default Home;
