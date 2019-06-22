import React, {Component}from 'react';
import Table from 'react-bootstrap/Table';

class ResultList extends Component{

    constructor(props){
        super(props);
            this.state={
                calculations: [],
                error: null
        }
    }

    componentDidMount(){
        this.fetchResults()
    }
    fetchResults(){
        fetch("http://localhost:8080/getResults")
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
          
                        calculations: result.calculations
                    });
                },
                (error) => {
                    this.setState({

                        error
                    });
            }
        )
      }
    render(){
        var { calculations, error } = this.state;
        if (error) {
            return <div>Error: {error.message}</div>;
        } else {
            return (
                <Table id='resultsTable'>
                    <tbody>
                        <tr>
                            <td>Id</td>
                            <td>Number 1</td>
                            <td>Operand</td>
                            <td>Number 2</td>
                            <td>Result</td>
                        </tr>
                        {calculations.map(calculation=> {
                            return(<tr>
                                    {Object.values(calculation).map(value=>{
                                        return(<td key={value.id}>{value}</td>)})}
                                    </tr>)
                        })}
                    </tbody >
                </Table >
            )
        } 

    }

}

export default ResultList;
            