import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    port: 3006,
    strictPort: true,  // Ensures the server always runs on port 3006, and fails if it's unavailable
  }
})
