import React from 'react';

export const PaperDetail = () => {
  const paperinformation = [
    {
      papertitle: 'The insights of ruminal culturomics',
      paperstatus: 'Pending',
      author: 'Mike Wazowski',
      tags: ['historical,cultural,ethnic'],
    },
    {
      papertitle: 'The concept of global health security',
      paperstatus: 'Submitted',
      author: 'Walter white',
      tags: ['Medical,safety,health'],
    },
  ];

  return (
    <div className="outerlayout">
      <div className="paperbox">
        <h2>PaperTitle</h2>
        <h4>author name</h4>
        <div className="tags">tag1 tag2 tag3</div>
        <div className="review-box"></div>
      </div>
    </div>
  );
};
