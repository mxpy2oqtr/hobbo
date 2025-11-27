import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import Header from './components/Header';
import SideNav from './components/SideNav';
import MainContent from './components/MainContent';
import HomePage from './pages/HomePage';
import StatisticsPage from './pages/StatisticsPage';
import NutritionPage from './pages/NutritionPage';
import ActivityPage from './pages/ActivityPage';
import RemindersPage from './pages/RemindersPage';
import ProfilePage from './pages/ProfilePage';

function App() {
  return (
    <Router>
      <div className="App">
        <SideNav />
        <div className="content">
          <Header />
          <MainContent>
            <Routes>
              <Route path="/" element={<HomePage />} />
              <Route path="/statistics" element={<StatisticsPage />} />
              <Route path="/nutrition" element={<NutritionPage />} />
              <Route path="/activity" element={<ActivityPage />} />
              <Route path="/reminders" element={<RemindersPage />} />
              <Route path="/profile" element={<ProfilePage />} />
            </Routes>
          </MainContent>
        </div>
      </div>
    </Router>
  );
}

export default App;
