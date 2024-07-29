import React from 'react';

function Navbar() {
    return (
        <nav className="bg-gray-800 p-4 w-screen">
            <div className="container mx-auto flex justify-between items-center">
                <div className="text-white text-lg font-bold">
                Horror Car Show
                </div>
                <div className="space-x-4">
                <a href="/" className="text-gray-300 hover:text-white">Home</a>
                <a href="/cars" className="text-gray-300 hover:text-white">Cars</a>
                <a href="/services" className="text-gray-300 hover:text-white">Services</a>
                <a href="/login" className="text-gray-300 hover:text-white">Login</a>
                </div>
            </div>
        </nav>
    );
}

export default Navbar;