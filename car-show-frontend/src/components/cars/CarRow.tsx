import { useState } from "react";
import Car from "../../type/Car";
import UpdateCar from "./UpdateCar";

function CarRow({data}: {data:Car}) {
    const {id, make, model, color, price, year} = data;
    const [isUpdateOpen, setIsUpdateOpen] = useState(false)
    const isAuthorized = sessionStorage.getItem("Authorization")
    const openUpdate = () => {
        setIsUpdateOpen(true);
    }

    return (
        <>
            <tr key={id} className="text-center border-2 border-double border-amber-300 hover:bg-gray-600/70 hover:shadow-md">
                <td>{make}</td>
                <td>{model}</td>
                <td>{color}</td>
                <td>${parseFloat(price).toFixed(2)}</td>
                <td>{year}</td>
                <td>{isAuthorized ? <button onClick={()=>openUpdate()} className="border-teal-500  rounded-md border-2 bg-cyan-400 p-1 hover:bg-cyan-700 hover:shadow-lg justify-end">Edit</button> : null}</td>
            </tr>
            <UpdateCar isUpdateOpen={isUpdateOpen} car={data} setIsUpdateOpen={setIsUpdateOpen} />
        </>
    );
}

export default CarRow;