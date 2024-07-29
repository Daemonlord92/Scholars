import { Routes, Route } from 'react-router-dom'
import Homepage from './static/Homepage'
import Navbar from './static/Navbar'
import CarIndex from './components/cars/CarIndex'
import Login from './components/auth/Login'

function App() {
  
  return (
    <>
      <Navbar />
      <div className='mx-auto bg-zinc-800 p-16 h-screen w-screen'>
      <Routes>
        <Route path="/" element={<Homepage/>} />
        <Route path='/cars' element={<CarIndex/>} />
        <Route path='/login' element={<Login />} />
      </Routes>
      </div>
    </>
  )
}

export default App
