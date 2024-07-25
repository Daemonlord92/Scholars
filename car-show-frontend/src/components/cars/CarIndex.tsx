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
        <div className="m-auto p-20 border-red-700 bg-white">
            <h1 className="text-4xl">Current Car List</h1>
            <div>
                <button onClick={openCreate}>Create new car</button>
                <CreateCar isOpen={isCreateOpen} onClose={closeCreate} />
                <table className="w-full">
                    <thead>
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