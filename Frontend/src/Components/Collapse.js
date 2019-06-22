import React, { Component } from "react";
import ResultList from "../Services/ResultList";

class Collapse extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isOpen: props.isOpen,
        };
        this.child = React.createRef();
        this.myRef = React.createRef();
        this.setContentRef = r => this.contentEl = r;
        this.setContainerRef = r => this.containerEl = r;
        this.toggle = () => this.setState(s => ({ isOpen: !s.isOpen }));
        this.onChange = this.onChange.bind(this);
    }
    componentWillReceiveProps(nextProps) {
        if (nextProps.isOpen !== this.props.isOpen && nextProps.isOpen !== this.state.isOpen) {
            this.toggle();
        }
    }
    componentDidMount() {
        this.updateHeight(this.state.isOpen);
    }

    componentDidUpdate() {
        this.updateHeight(this.state.isOpen);
    }

    updateHeight(isOpen) {
        this.lastRAF && cancelAnimationFrame(this.lastRAF);
        if (isOpen) {
            this.lastRAF = requestAnimationFrame(() => {
                const height = `${this.contentEl.scrollHeight}px`;
                this.lastRAF = requestAnimationFrame(() => {
                    this.lastRAF = requestAnimationFrame(() => {
                        this.containerEl.style.height = height;
                        this.lastRAF = null;
                    });
                });
            });
        } else {
            this.containerEl.style.height = '0px';
        }
    }
    onChange() {
        this.toggle();
        this.child.current.fetchResults();

    }


    render() {
        return (
            <div style={historyStyle}>
                <div style={mainStyle}>
                    <div onClick={this.onChange} style={toggleStyle}>History</div>
                    <div ref={this.setContainerRef} style={containerStyle}>
                        <div ref={this.setContentRef} style={contentStyle}>
                            <ResultList ref={this.child}/>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

const mainStyle = { fontFamily: 'Arial, Sans-Serif', border: '1px solid black', display: 'inline-block', borderRadius: '25px', background:"#ff992b", width:"430px", borderColor:"gray"};
const toggleStyle = { padding: '10px', cursor: 'pointer' };
const containerStyle = { transition: '1.75s', overflow: 'hidden'};
const contentStyle = { padding: '10px' ,overflow: 'hidden'};
const historyStyle ={ textAlign: 'center', padding:'20px'};

Collapse.defaultProps = {
    isOpen: false
};

export default Collapse;