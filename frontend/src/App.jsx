import { Route, Routes } from 'react-router-dom'
import Layout from './components/Layout'
import ComplaintsPage from './pages/ComplaintsPage'
import NoticesPage from './pages/NoticesPage'

export default function App() {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route index element={<NoticesPage />} />
        <Route path="complaints" element={<ComplaintsPage />} />
      </Route>
    </Routes>
  )
}
