import React from 'react';
import { render, screen } from '@testing-library/react';
import {VideoCall} from './App';

test('renders learn react link', () => {
  render(<VideoCall />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
