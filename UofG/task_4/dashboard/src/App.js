import React from 'react';
import './App.css';
import logo from './holberton-logo.jpg'
import { getFullYear, getFooterCopy } from './utils';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>School dashboard</h1>
        {/* <p>
          Edit <code>src/App.js</code> and save to reload.
        </p> */}
        {/* <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a> */}
      </header>
      <body className='App-body'>
        <main>
          <p>Login to access the full dashboard</p>
          <form className='App-form'>
            <div>
              <label htmlFor="email">Email:</label>
              <input type="email" id="email" name="email" />
            </div>
            <div>
              <label htmlFor="password">Password:</label>
              <input type="password" id="password" name="password" />
            </div>
            <button type="submit">OK</button>
          </form>
        </main>
      </body>
      <footer className='App-footer'><p>&copy; {getFullYear()} - {getFooterCopy(true)}</p></footer>
    </div>
  );
}

export default App;
