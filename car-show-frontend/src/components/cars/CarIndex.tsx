import { useQuery } from "@tanstack/react-query";
import Car from "../../type/Car";
import axios from "axios";
import CarRow from "./CarRow";
import { useState } from "react";
import CreateCar from "./CreateCar";

function CarIndex() {
    const {data, error, isLoading } = useQuery<Car[], Error>({
        queryKey: ['cars'],
        queryFn: async function():Promise<Car[]> {
            const request = await axios.get(import.meta.env.VITE_API_URL + "/car/");
            const response = await request.data;
            return response;
        }
    })

    const isAuthorized = sessionStorage.getItem("Authorization")

    const [isCreateOpen, setCreateOpen] = useState(false);
  

    const openCreate = () => {
        setCreateOpen(true)
    }

    const closeCreate = () => {
        setCreateOpen(false)
    }

    if(isLoading) return <div>Loading...</div>
    if(error) return <div>An error has occurred, Time to cry under the desk: {error.message}</div>

    return (
        <div className="m-auto p-10 border-red-700 bg-white">
            <h1 className="text-4xl font-bold text-transparent bg-clip-text bg-gradient-to-r from-red-800 to-red-300">Current Car List</h1>
            <div className="flex flex-wrap my-3">
                {isAuthorized ? <div className="flex flex-row justify-end w-full my-3">
                    <button onClick={openCreate} className="border-teal-500  rounded-md border-2 bg-cyan-400 p-1 hover:bg-cyan-700 hover:shadow-lg justify-end">Create new car</button>
                </div> : null}
                <CreateCar isOpen={isCreateOpen} onClose={closeCreate} />
                <table className="w-full flex-row border border-double border-2 border-amber-500">
                    <thead className="border border-dashed border-2 border-amber-400">
                        <tr className="">
                            <th>Make</th>
                            <th>Model</th>
                            <th>Color</th>
                            <th>Price</th>
                            <th>Year</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            data?.map((car) => (
                                <CarRow data={car}/>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default CarIndex;