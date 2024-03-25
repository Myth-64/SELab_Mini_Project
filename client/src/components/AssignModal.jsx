import React, { useEffect, useState } from 'react';
import { IoMdClose } from 'react-icons/io';
import '../assets/styles/AssignModal.css';
import UserBadge from './UserBadge';
import { toast } from 'react-toastify';
import UserListItem from './UserListItem';
import axios from 'axios';

const AssignModal = ({
  isModalOpen,
  modalContent,
  onClose,
  setModalContent,
  paperId,
}) => {
  if (isModalOpen !== true) {
    return null;
  }
  let map1 = new Map();
  {
    modalContent.map((content, index) => {
      const { name, id } = content;
      map1.set(name, id);
    });
  }
  const [selectedUsers, setSelectedUsers] = useState([]);
  const [selectedUsersId, setselectedUsersId] = useState([]);

  useEffect(() => {}, [selectedUsersId]);

  const handleGroup = (userToAdd, userToAddId) => {
    if (
      selectedUsers.includes(userToAdd) ||
      selectedUsersId.includes(userToAddId)
    ) {
      // toast({
      //   title: 'User already added',
      //   status: 'warning',
      //   duration: 5000,
      //   isClosable: true,
      //   position: 'top',
      // });
      toast.warning('User already addded');

      return;
    }

    setSelectedUsers([...selectedUsers, userToAdd]);

    setselectedUsersId([...selectedUsersId, userToAddId]);
    setModalContent(modalContent.filter((x) => !selectedUsers.includes(x)));
  };
  const handleDelete = (delUser) => {
    setSelectedUsers(selectedUsers.filter((sel) => sel !== delUser));
    setselectedUsersId(
      selectedUsersId.filter((sel) => sel !== map1.get(delUser))
    );
  };

  const handlesubmit = async () => {
    const data = {
      paperId: paperId,
      username: localStorage.getItem('username'),
      userIds: selectedUsersId,
    };
    console.log(data);
    try {
      const resp = await axios.post(
        'http://localhost:8080/api/papers/addReviewers',
        data
      );
      toast.success(resp.data.message);
    } catch (error) {}
    console.log(data);
  };
  //handle submit button that will post reviewer list after selection,onclick closes modal too

  return (
    <section className="modal">
      <div className="modal-content p-lg-4">
        <h2>Reviewer List</h2>
        <div className="exit-icon">
          <IoMdClose onClick={onClose} />
        </div>
        <div className="selected">
          {selectedUsers.map((u, index) => (
            <UserBadge
              key={index}
              content={u}
              handleFunction={() => handleDelete(u)}
            />
          ))}
        </div>
        {modalContent.map((content, index) => {
          const { name, status, id } = content;
          return (
            <UserListItem
              key={index}
              name={name}
              id={id}
              handleFunction={() => handleGroup(name, id)}
            />
          );
        })}
        <button className="modal-button" onClick={handlesubmit}>
          Submit{' '}
        </button>
      </div>
    </section>
  );
};

export default AssignModal;
