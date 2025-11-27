import React from 'react';

const HomePage = () => {
  return (
    <div className="home-page">
      <div className="summary-cards">
        <div className="card">
          <h3>Salud General</h3>
          <p>Bueno</p>
        </div>
        <div className="card">
          <h3>Calorías</h3>
          <p>1200 / 2000</p>
        </div>
        <div className="card">
          <h3>Actividad Física</h3>
          <p>30 mins</p>
        </div>
        <div className="card">
          <h3>Hidratación</h3>
          <p>1.5 L</p>
        </div>
      </div>
      <div className="main-graph">
        {/* Placeholder for the main graph */}
        <h3>Evolución Semanal</h3>
      </div>
      <div className="alerts">
        {/* Placeholder for alerts */}
        <p>No hay alertas nuevas.</p>
      </div>
    </div>
  );
};

export default HomePage;
