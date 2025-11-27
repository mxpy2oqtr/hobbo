import React from 'react';
import { Link } from 'react-router-dom';

const SideNav = () => {
  return (
    <nav className="side-nav">
      <ul>
        <li><Link to="/">Inicio</Link></li>
        <li><Link to="/statistics">Estadísticas</Link></li>
        <li><Link to="/nutrition">Nutrición</Link></li>
        <li><Link to="/activity">Actividad</Link></li>
        <li><Link to="/reminders">Recordatorios</Link></li>
        <li><Link to="/profile">Perfil</Link></li>
      </ul>
    </nav>
  );
};

export default SideNav;
