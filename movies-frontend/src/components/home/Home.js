import React from 'react'
import Hero from '../hero/Hero'

function Home({movies}) {
  return (
    <Hero movies = {movies}></Hero>
  )
}

export default Home