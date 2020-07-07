import styled from 'vue-styled-components';

export const Container = styled.div`
    background: #7159c1;
    border-radius: 10px;
    justify-content: center;
    align-items: center;
    padding-bottom: 20px;
    padding-top: 5px;
`;

export const Title = styled.h1`
    color: #FFF;
    font-size: 30px;
    text-align: center;
`;

export const BalanceInfo = styled.div`
    background: #FFF;
    border-radius: 6px;
    width: 300px;
    height: 600px;
    margin: 0 auto;
    margin-bottom: 20px;
    padding-top: 10px;
    display: flex;
    flex-direction: column;
    padding-left: 30px;
    padding-right: 30px;
    justify-content: center;
`;

export const Form = styled.form`
`;

export const BalanceValue = styled.h1`
    color: #000;
    font-size: 30px;
`;

export const Input = styled.input`
    padding: 6px;
    border-radius: 6px;
    border: 1px solid #ccc;
    height: 20px;
    width: 286px;
    margin-top: 10px;
    margin-bottom: 10px;
    text-align: center;
`;

export const FormButton = styled.button`
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

export const ExtractButton = styled.button`
    padding: 6px;
    border-radius: 6px;
    height: 30px;
    width: 100%;
    margin-top: 10px;
    color: #7159c1;
    background: transparent;
    border: 1px solid #7159c1;
    font-weight: bold;
    cursor: pointer;
`;