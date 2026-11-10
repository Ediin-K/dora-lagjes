const BASE = '/api'

async function request(path, options = {}) {
  const res = await fetch(BASE + path, {
    headers: { 'Content-Type': 'application/json' },
    ...options,
  })
  if (!res.ok) {
    const body = await res.json().catch(() => ({}))
    throw new Error(body.error || `Request failed (${res.status})`)
  }
  return res.status === 204 ? null : res.json()
}

export const noticesApi = {
  list: () => request('/notices'),
  create: (data) => request('/notices', { method: 'POST', body: JSON.stringify(data) }),
  remove: (id) => request(`/notices/${id}`, { method: 'DELETE' }),
}

export const complaintsApi = {
  list: () => request('/complaints'),
  create: (data) => request('/complaints', { method: 'POST', body: JSON.stringify(data) }),
  updateStatus: (id, status) => request(`/complaints/${id}/status?status=${status}`, { method: 'PATCH' }),
}
