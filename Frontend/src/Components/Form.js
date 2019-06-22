import React, { Component, Fragment } from "react";
import Button from "react-bootstrap/Button";
import "../Style/Form.css";


class Form extends Component {

    constructor(props) {
        super(props);
        this.state = {
            op: "sum",
            num1: "",
            num2: "",
            result: "",
            buttonArray: [
                { name: "Add", value: "sum" },
                { name: "Subtract", value: "sub" },
                { name: "Divide", value: "div" },
                { name: "Multiply", value: "prod" }
            ]
        };
        this.onSubmit = this.handleSubmit.bind(this);
        this.onChange = this.onChange.bind(this);
        this.handleChangeForm1 = this.handleChangeForm1.bind(this);
        this.handleChangeForm2 = this.handleChangeForm2.bind(this);
    }

    handleSubmit(event, num1, num2, op) {
        if (this.validateInput(num1, num2)){
        let requestBody = {"num1": parseFloat(num1), "op": op, "num2": parseFloat(num2)};
        event.preventDefault();
        fetch('http://localhost:8080/calculate',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(requestBody)
            })
            .then(res => {
                res.json().then(data => {
                    this.setState({result: data.calculationResult})
                }).catch(error => console.error('Error:', error));
            })
        } else{
            this.setState({result: "Enter both numbers"})
        }
    }

    validateInput(form1Value, form2Value){
        return !(form1Value === "" || form2Value === "");
    }

    onChange(value) {
        this.setState({ op: value })
    }

    handleChangeForm1(event) {
        this.setState({ num1: event.target.value });
    }
    handleChangeForm2(event) {
        this.setState({ num2: event.target.value });
    }
    handleChangeForm3(){
       return this.state.result;
    }

    render() {
        return (
            <Fragment>
                <div className="buttons">
                    {this.state.buttonArray.map((el, index) =>
                        <Button id="menu-button" key={index} onClick={() => this.onChange(el.value)} variant={el.value === this.state.op ? "danger" : "warning"} className="button">
                            {el.name}
                        </Button>
                    )}
                </div>
                <div className="form-area">
                    <div className="form-group">
                        <label>Number 1</label>
                        <input type="text" id="num1" value={this.state.num1} onChange={this.handleChangeForm1} className="form-control form-control-md" />
                    </div>
                    <div className="form-group">
                        <label>Number 2</label>
                        <input type="text" id="num2" value={this.state.num2} onChange={this.handleChangeForm2} className="form-control form-control-md" />
                    </div>
                    <div className="form-group">
                        <label>Result</label>
                        <input type="text" id="res" value={this.state.result} onChange={this.handleChangeForm3} className="form-control form-control-md" readOnly/>
                    </div>
                    </div> 
                    <div id="calculate-button">
                        <Button variant="warning" onClick={(event) => this.handleSubmit(event, this.state.num1, this.state.num2, this.state.op)}>Calculate</Button>
                    </div>
            </Fragment>
        )
    }
}
export default Form;