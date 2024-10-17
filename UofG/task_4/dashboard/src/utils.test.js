import { getFullYear, getFooterCopy, getLastestNotification } from './utils';

describe('getFullYear', () => {
  it('should return the current year', () => {
    const currentYear = new Date().getFullYear();
    expect(getFullYear()).toBe(currentYear);
  });
});

describe('getFooterCopy', () => {
  it('should return "Holberton School" when the argument is true', () => {
    expect(getFooterCopy(true)).toBe('Holberton School');
  });

  it('should return "Holberton School main dashboard" when the argument is false', () => {
    expect(getFooterCopy(false)).toBe('Holberton School main dashboard');
  });
});

describe('getLatestNotification', () => {
  it('should return the correct latest notification string', () => {
    const expectedString = '<strong>Urgent requirement</strong> - complete by EOD';
    expect(getLastestNotification ()).toBe(expectedString);
  });
});
