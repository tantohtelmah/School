import React from 'react';
import './Notifications.css';
import { getLastestNotification, handleButtonClick } from './utils';
// import closeIcon from './close-icon.png';

function notification() {
	return <div className="Notifications">
		<button
        style={{ position: 'absolute', right: '10px', top: '10px' }}
        aria-label="Close"
        onClick={handleButtonClick}
		>
        {/* <img src={closeIcon} alt="close icon" /> */}
      </button>
		<p>Here is the list of notifications</p>
		<ul>
			<li data-priority="default" style={{ color: 'blue'}}>New course available</li>
			<li data-priority="urgent" style={{ color: 'red'}}>New resume available</li>
			<li dangerouslySetInnerHTML={getLastestNotification()} style={{ color: 'red'}}></li>
      </ul>
	</div>
}
export default notification;
