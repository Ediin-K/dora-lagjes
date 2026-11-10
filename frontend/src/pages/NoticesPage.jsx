import { useEffect, useState } from 'react'
import { noticesApi } from '../api/client'

export default function NoticesPage() {
  const [notices, setNotices] = useState([])
  const [form, setForm] = useState({ title: '', content: '' })
  const [error, setError] = useState('')

  const load = () => noticesApi.list().then(setNotices).catch((e) => setError(e.message))

  useEffect(() => {
    load()
  }, [])

  const submit = async (e) => {
    e.preventDefault()
    setError('')
    try {
      await noticesApi.create(form)
      setForm({ title: '', content: '' })
      load()
    } catch (err) {
      setError(err.message)
    }
  }

  const remove = async (id) => {
    await noticesApi.remove(id)
    load()
  }

  return (
    <section>
      <h2>Notices</h2>
      {error && <p className="error">{error}</p>}
      <form onSubmit={submit} className="card">
        <input
          placeholder="Title"
          value={form.title}
          onChange={(e) => setForm({ ...form, title: e.target.value })}
          required
        />
        <textarea
          placeholder="Content"
          value={form.content}
          onChange={(e) => setForm({ ...form, content: e.target.value })}
          required
        />
        <button type="submit">Post notice</button>
      </form>
      {notices.map((n) => (
        <article key={n.id} className="card">
          <h3>{n.title}</h3>
          <p>{n.content}</p>
          <small>{new Date(n.createdAt).toLocaleString()}</small>
          <button onClick={() => remove(n.id)}>Delete</button>
        </article>
      ))}
    </section>
  )
}
