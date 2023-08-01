import React from 'react';
import images from '..';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

const HeroDetail = (props) => {
  const {info} = props;
  const hero = info;
  // console.log("HeroDetails: info " + info + " key " + key);

  return (
      <Card>
        <div className="imgContainer">
          <Card.Img variant="top" src={images[props.info.alias.replaceAll(/\s/g, '')]} width="150px" />
        </div>
        <Card.Body>
            <Card.Title id={hero.id}>Alias: {hero.alias}</Card.Title>
            <Card.Text>Name: {hero.name}</Card.Text >
            <Button variant="primary">Like</Button>   
        </Card.Body>
      </Card>
  )
}

export default HeroDetail;