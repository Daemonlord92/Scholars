import { Routes, Route } from 'react-router-dom'
import Homepage from './static/Homepage'
import Navbar from './static/Navbar'

function App() {
  
  return (
    <>
      <Navbar />
      <div className='container mx-auto bg-zinc-800 p-16 h-screen w-screen'>
      <Routes>
        <Route path="/" element={<Homepage/>} />
      </Routes>
      </div>
    </>
  )
}

export default App
