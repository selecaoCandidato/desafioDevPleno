import styled from 'vue-styled-components';

export const Container = styled.div`
    background: #7159c1;
    border-radius: 10px;
    padding-bottom: 20px;
    padding-top: 5px;
`;

export const Title = styled.h1`
    color: #FFF;
    font-size: 30px;
    text-align: center;
`;

export const ExtractInfo = styled.div`
    background: #FFF;
    border-radius: 6px;
    width: 300px;
    height: 600px;
    margin: auto;
    margin-bottom: 20px;
    padding-top: 10px;
    display: flex;
    flex-direction: column;
    padding-left: 30px;
    padding-right: 30px;
    justify-content: center;
`;

export const ExtractContainer = styled.div`
    padding-right: 23px;
`;

export const ExtractTitle = styled.h1`
    color: #000;
    font-size: 30px;
    text-align: center;
`;

export const ExtractButton = styled.button`
    padding: 6px;
    border-radius: 6px;
    height: 30px;
    width: 100%;
    margin-top: 10px;
    color: #FFF;
    background: #7159c1;
    border: 0;
    cursor: pointer;
`;

export const Extract = styled.div`
    background: #FFF;
    border-radius: 6px;
    width: 300px;
    height: 600px;
    margin: 0 auto;
    margin-bottom: 20px;
    padding-top: 10px;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding-left: 30px;
    padding-right: 30px;
    overflow-y: scroll;
`;

export const ExtractItem = styled.div`
    background: transparent;
    border-radius: 6px;
    width: 160px;
    height: 160px;
    display: flex;
    flex-direction: column;
    border: 1px solid #7159c1;
    justify-content: center;
    align-items: center;
    margin-top: 10px;
    margin-bottom: 5px;
`;