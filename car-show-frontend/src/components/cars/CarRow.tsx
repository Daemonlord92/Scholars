import Car from "../../type/Car";

function CarRow({data}: {data:Car}) {
    const {id, make, model, color, price, year} = data;
    return (
        <tr key={id} className="text-center">
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