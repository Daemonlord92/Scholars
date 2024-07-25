import { Routes, Route } from 'react-router-dom'
import Homepage from './static/Homepage'
import Navbar from './static/Navbar'
import CarIndex from './components/cars/CarIndex'

function App() {
  
  return (
    <>
      <Navbar />
      <div className='mx-auto bg-zinc-800 p-16 h-screen w-screen'>
      <Routes>
        <Route path="/" element={<Homepage/>} />
        <Route path='/cars' element={<CarIndex/>} />
      </Routes>
      </div>
    </>
  )
}

export default App
