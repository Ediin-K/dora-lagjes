import { useEffect, useState } from 'react'
import { complaintsApi } from '../api/client'

const STATUSES = ['OPEN', 'IN_PROGRESS', 'RESOLVED']
const EMPTY = { title: '', description: '', location: '' }

export default function ComplaintsPage() {
  const [complaints, setComplaints] = useState([])
  const [form, setForm] = useState(EMPTY)
  const [error, setError] = useState('')

  const load = () => complaintsApi.list().then(setComplaints).catch((e) => setError(e.message))

  useEffect(() => {
    load()
  }, [])

  const submit = async (e) => {
    e.preventDefault()
    setError('')
    try {
      await complaintsApi.create(form)
      setForm(EMPTY)
      load()
    } catch (err) {
      setError(err.message)
    }
  }

  const changeStatus = async (id, status) => {
    await complaintsApi.updateStatus(id, status)
    load()
  }

  return (
    <section>
      <h2>Complaints</h2>
      {error && <p className="error">{error}</p>}
      <form onSubmit={submit} className="card">
        <input
          placeholder="Title"
          value={form.title}
          onChange={(e) => setForm({ ...form, title: e.target.value })}
          required
        />
        <input
          placeholder="Location (optional)"
          value={form.location}
          onChange={(e) => setForm({ ...form, location: e.target.value })}
        />
        <textarea
          placeholder="Describe the problem"
          value={form.description}
          onChange={(e) => setForm({ ...form, description: e.target.value })}
          required
        />
        <button type="submit">Submit complaint</button>
      </form>
      {complaints.map((c) => (
        <article key={c.id} className="card">
          <h3>{c.title}</h3>
          {c.location && <small>{c.location}</small>}
          <p>{c.description}</p>
          <select value={c.status} onChange={(e) => changeStatus(c.id, e.target.value)}>
            {STATUSES.map((s) => (
              <option key={s} value={s}>{s}</option>
            ))}
          </select>
        </article>
      ))}
    </section>
  )
}
