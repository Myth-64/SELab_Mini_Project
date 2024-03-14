import React from 'react';
import '../assets/styles/PaperDetails.css';
export const PaperDetail = () => {
  const paperinformation = {
    papertitle: 'The insights of ruminal culturomics',
    paperstatus: 'Pending',
    author: 'Mike Wazowski',
    tags: ['historical', 'cultural', 'ethnic', 'ethnic', 'ethnic'],
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
  const { papertitle, paperstatus, author, tags } = paperinformation;

  return (
    <div className="outerlayout">
      <div className="paperbox">
        <h2>{papertitle}</h2>
        <h4>{author}</h4>
        <div className="tagbox">
          {tags.map((tag) => {
            return <div className="tag">{tag}</div>;
          })}
        </div>
      </div>
      <div className="panel">shhhs</div>
      <div className="review-box">
        <h2>Reviews</h2>
        {paperdetails.map((details) => {
          const { papertitle, paperstatus } = details;
          return (
            <div className="paperinfobox">
              <h4
                style={{ fontFamily: 'sans-serif', fontWeight: 'normal' }}
                onClick={(e) => gotoDetail(e, papertitle)}
              >
                {papertitle}
              </h4>
            </div>
          );
        })}
      </div>
    </div>
  );
};
