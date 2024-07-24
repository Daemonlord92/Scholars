import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const [characters, setCharacters] = useState([]);
  const [page, setPage] = useState(0)

  useEffect(() => {
    setPage(1)
    async function fetchData() {
      const request = await fetch("https://rickandmortyapi.com/api/character/?page=" + page);
      const response = await request.json();
      return response;
    }
    fetchData().then(result => {
      setCharacters(result.results)
      console.table(characters);
    })
  }, []);

  useEffect(() => {
    async function fetchData() {
      const request = await fetch("https://rickandmortyapi.com/api/character/?page=" + page);
      const response = await request.json();
      return response;
    }
    fetchData().then(result => {
      setCharacters(result.results)
    })
  }, [page])

  return (
    <>
      <h1>Rick And Morty</h1>
      <div className='container'>
        <div>
          <input type="button" onClick={() => setPage(page - 1)} value="Prev"/>
          <input type="button" onClick={() => setPage(page + 1)} value="Next"/>
        </div>
        {characters ? characters.map(character => {
          return(
            <div className='card-container'>
              <h3>{character.name}</h3>
              <img src={character.image} alt="" />
            </div>
          )
        }) : 'Loading'}
      </div>
    </>
  )
}

export default App
