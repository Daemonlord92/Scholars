import Car from "../../type/Car";

function CarRow({data}: {data:Car}) {
    const {id, make, model, color, price, year} = data;
    return (
        <tr key={id} className="text-center border-2 border-double border-amber-300 hover:bg-gray-600/70 hover:shadow-md">
            <td>{make}</td>
            <td>{model}</td>
            <td>{color}</td>
            <td>${parseFloat(price).toFixed(2)}</td>
            <td>{year}</td>
            <td></td>
        </tr>
    );
}

export default CarRow;