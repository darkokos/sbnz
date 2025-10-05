import { Dispatch, SetStateAction } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";

export default function HomeCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  const onSubmit = () => {};

  return (
    <HomeStateCardTemplate title="Home" onSubmit={onSubmit}>
      asd
    </HomeStateCardTemplate>
  );
}
