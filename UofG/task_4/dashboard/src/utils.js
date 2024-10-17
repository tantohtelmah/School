
import './App.css';

export function getFullYear() {
	return new Date().getFullYear();
}
export function getFooterCopy(isIndex) {
	if (isIndex) {
		return isIndex ? "Holberton School" : "Holberton School main dashboard";
	}
}

export function getLastestNotification() {
	return { __html: '<strong>Urgent requirement</strong> - complete by EOD' };
}

export function  handleButtonClick() {
	console.log('Close button has been clicked');
}
