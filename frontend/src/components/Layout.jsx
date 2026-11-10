import { NavLink, Outlet } from 'react-router-dom'

export default function Layout() {
  return (
    <>
      <header className="header">
        <h1>Dora Lagjes</h1>
        <nav>
          <NavLink to="/" end>Notices</NavLink>
          <NavLink to="/complaints">Complaints</NavLink>
        </nav>
      </header>
      <main className="main">
        <Outlet />
      </main>
    </>
  )
}
