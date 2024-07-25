import React from 'react';

function Homepage() {
    return (
        <div className='m-auto flex flex-wrap justify-center bg-orange-800 w-full p-10'>
            <h1 className='text-4xl mb-5 mx-auto px-20'>Welcome to the Horror Car Show</h1>
            <div className='flex justify-between justify-items-center mx-auto'>
                <div className='px-20'>
                    <h3 className='text-2xl'>
                        See the spooky car we have
                    </h3>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dolor voluptas quam quis animi. Aliquam quasi nulla quis dolorum, dolor nam magni atque eligendi similique in voluptate odit eius cumque officiis?</p>
                </div>
                <div className='px-20'>
                    <h3 className='text-2xl'>
                        Ask the owners about the story of the car
                    </h3>
                    <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius, qui in voluptatem molestiae eos nesciunt adipisci dolor inventore iure dolorum cumque atque perferendis impedit aliquid optio saepe maxime. Minima, ipsa.
                    </p>
                </div>
            </div>
        </div>
    );
}

export default Homepage;