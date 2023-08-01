import React from 'react';
import images from '..';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { useState } from 'react';
import { Row } from 'react-bootstrap';
import { Col } from 'react-bootstrap';
const HeroDetail = (props) => {
  const {info} = props;
  const hero = info;
  const[counter, setCounter] = useState(0);
const incrementCounter =()=>{
  setCounter(counter+1);
  props.parentCount(props.info.alias);
}
  // console.log("HeroDetails: info " + info + " key " + key);

  return (
      <Card>
        <div className="imgContainer">
          <Card.Img variant="top" src={images[props.info.alias.replaceAll(/\s/g, '')]} width="150px" />
        </div>
        <Card.Body>
            <Card.Title id={hero.id}>Alias: {hero.alias}</Card.Title>
            <Row>
              <Col><Button variant="primary" onClick={incrementCounter}>Like</Button></Col>
              <Col>{counter > 0  && <Card.Text >Likes: {counter}</Card.Text > }</Col>
            </Row>
        </Card.Body>
      </Card>
  )
}

export default HeroDetail;